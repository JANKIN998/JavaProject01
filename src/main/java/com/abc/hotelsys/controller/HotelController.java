package com.abc.hotelsys.controller;

import com.abc.hotelsys.domain.Hotel;
import com.abc.hotelsys.exception.HotelSysException;
import com.abc.hotelsys.service.HotelService;
import com.abc.hotelsys.service.HotelServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;

@Controller
public class HotelController {

    @GetMapping("/hotels/input")
    public String toInput() throws Exception{
        return "hotel/input_hotel";
    }

    @PostMapping("/hotels")
    public String saveHotel(Hotel hotel, MultipartFile hotelPhoto) throws Exception{
//        System.out.println(hotel);
//        System.out.println(hotelPhoto);
        hotel.setHotelPic(hotelPhoto.getBytes());

        HotelService hotelService = new HotelServiceImpl();
        hotelService.createHotel(hotel);

        System.out.println(hotel);
        System.out.println("create hotel is ok!");

        return "redirect:/hotels";
    }

    @GetMapping("/hotels")
    public String loadHotels(Model model) throws Exception{

        HotelService hotelService = new HotelServiceImpl();
        model.addAttribute("hotelList",hotelService.loadHotels());

        return "hotel/list_hotels";
    }

    @GetMapping("/hotels/{hotelId}/pic")
    public String getHotelPic(@PathVariable int hotelId, HttpServletResponse response, HttpServletRequest request) throws Exception{

        HotelService hotelService = new HotelServiceImpl();
        byte[] picData = hotelService.loadPicById(hotelId);

//        System.out.println(picData);
        if(picData==null || picData.length==0){
            String defaultPicPath = request.getRealPath("/")+"static/pics/no-pic.jpg";
            System.out.println(defaultPicPath);
            FileInputStream fis =new FileInputStream(defaultPicPath);
            picData=new byte[fis.available()];
            fis.read(picData);
        }

        response.setContentType("image/jpeg");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(picData);
        outputStream.flush();
        outputStream.close();

        return null;

    }

    @DeleteMapping("/hotels/{hotelId}")
    public String removeHotel(@PathVariable int hotelId, HttpSession session) throws Exception{

        HotelService hotelService = new HotelServiceImpl();

        try{
            hotelService.removeHotel(hotelId);
        }catch(HotelSysException e){
            session.setAttribute("errMsg",e.getMessage());
        }

        return "redirect:/hotels";
    }

    @GetMapping("/hotels/{hotelId}")
    public String getHotelById(@PathVariable int hotelId, Model model) throws Exception{

        HotelService hotelService = new HotelServiceImpl();
        Hotel hotel = hotelService.loadHotelById(hotelId);

        model.addAttribute("hotel",hotel);

        return "hotel/update_hotel";

    }

    @PostMapping("/hotels/{hotelId}")
    public String updateHotel(Hotel hotel, @PathVariable int hotelId, MultipartFile hotelPhoto) throws Exception {

//        System.out.println(hotelPhoto);

        hotel.setHotelId(hotelId);

        HotelService hotelService = new HotelServiceImpl();
        if(hotelPhoto!=null && hotelPhoto.getBytes().length>0)
          hotel.setHotelPic(hotelPhoto.getBytes());
        else {
          hotel.setHotelPic(hotelService.loadPicById(hotelId));
        }

        System.out.println(hotel);

        hotelService.updateHotel(hotel);

        return "redirect:/hotels";

    }


}
