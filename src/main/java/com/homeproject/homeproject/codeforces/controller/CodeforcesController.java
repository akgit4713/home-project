package com.homeproject.homeproject.codeforces.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.homeproject.homeproject.codeforces.service.CodeforcesService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/codeforces")
public class CodeforcesController {
    private static final Logger LOG = LoggerFactory.getLogger(CodeforcesController.class);
    @Autowired
    private CodeforcesService codeforcesService;

    @GetMapping("/blogComments")
    @ResponseBody
    public ResponseEntity<?> getComments(@NotNull @RequestBody ObjectNode objectNode){
        String key = objectNode.get("id").asText();
        codeforcesService.getBlogComments(key);
        return ResponseEntity.ok().build();
    }
}
