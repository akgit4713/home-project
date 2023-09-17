package com.homeproject.homeproject.codeforces.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.homeproject.homeproject.codeforces.service.CodeforcesService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/codeforces")
public class CodeforcesController {
    private static final Logger LOG = LoggerFactory.getLogger(CodeforcesController.class);
    private static final Gson gson = new Gson();
    @Autowired
    private CodeforcesService codeforcesService;

    @GetMapping("/blogComments")
    @ResponseBody
    public ResponseEntity<?> getComments(@NotNull @RequestBody ObjectNode objectNode) {
        String key = objectNode.get("id").asText();
        Map<String,String> mp = new HashMap<>();
        mp.put("aaa","iii");
        String mapSt= gson.toJson(mp);
        LOG.info("Map string {}",mapSt);
        Map<String,String> nmp = gson.fromJson(mapSt, Map.class);
        LOG.info("Converted map {}", nmp);

        return ResponseEntity.ok().build();
    }
}
