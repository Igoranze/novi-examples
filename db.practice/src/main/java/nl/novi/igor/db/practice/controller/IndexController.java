package nl.novi.igor.db.practice.controller;

import nl.novi.igor.db.practice.dto.Game;
import nl.novi.igor.db.practice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    GameService repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index() {

        String table = "<center><table style=\"border: 1px solid black\"><tr><th>Game ID</th><th>Nickname</th></tr>";

        for (Game g : repository.getAllGames()) {
            table += "<tr><td>" + g.getId() + "</td><td>" + g.getPlayerWon().getNickname() + "</td></tr>";
        }
        table += "</table></center>";
        return table;
    }
}
