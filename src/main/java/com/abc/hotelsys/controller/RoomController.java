package com.abc.hotelsys.controller;

import com.abc.hotelsys.domain.Room;
import com.abc.hotelsys.service.*;
import com.abc.hotelsys.utils.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomController extends BaseController{

    @GetMapping("/rooms/input")
    public String toInput(Model model) throws Exception{

        HotelService hotelService = new HotelServiceImpl();
        model.addAttribute("hotelList",hotelService.loadHotels());

        return "room/input_room";
    }

    @PostMapping("/rooms")
    public String saveRoom(Room room) throws Exception{
//        System.out.println(room);
        RoomService roomService = new RoomServiceImpl();
        roomService.createRoom(room);
        return "redirect:/rooms";
    }

    @GetMapping("/rooms")
    public String loadRooms(RoomQueryHelper helper, Page page, Model model) throws Exception{

        RoomService roomService = new RoomServiceImpl();
        HotelService hotelService = new HotelServiceImpl();

        model.addAttribute("hotelList",hotelService.loadHotels());
        model.addAttribute("page",roomService.loadPagedRooms(helper,page));

        System.out.println(helper);
        System.out.println(page);

        return "room/list_rooms";

    }


    @DeleteMapping("/rooms/{roomId}")
    public String removeRoom(@PathVariable int roomId) throws  Exception{

        RoomService roomService = new RoomServiceImpl();
        roomService.removeRoom(roomId);

        return "redirect:/rooms";

    }

    @GetMapping("/rooms/{roomId}")
    public String preUpdateRoom(@PathVariable int roomId,Model model) throws Exception{

        RoomService roomService = new RoomServiceImpl();
        Room room = roomService.getRoomById(roomId);
        model.addAttribute("room",room);

        HotelService hotelService = new HotelServiceImpl();
        model.addAttribute("hotelList",hotelService.loadHotels());

        return "room/update_room";

    }

    @PutMapping("/rooms/{roomId}")
    public String updateRoom(Room room,@PathVariable int roomId) throws Exception{

        room.setRoomId(roomId);

        RoomService roomService = new RoomServiceImpl();
        roomService.updateRoom(room);

        return "redirect:/rooms";

    }


}
