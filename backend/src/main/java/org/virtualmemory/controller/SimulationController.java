package org.virtualmemory.controller;

import org.springframework.web.bind.annotation.*;
import org.virtualmemory.model.Simulator;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*") // React http://localhost:3000
@RestController
public class SimulationController {

    @PostMapping("/simulate")
    public Map<String, Object> simulate(@RequestBody Map<String, Object> request) {
        List<Integer> sequence = (List<Integer>) request.get("sequence");

        Integer ramSize = (Integer) request.getOrDefault("ramSize", 3);
        Integer maxPages = (Integer) request.getOrDefault("maxPages", 10);

        Simulator sim = new Simulator(ramSize, maxPages);

        for (int pageId : sequence) {
            sim.accessPage(pageId);
        }

        return Map.of(
                "frames", getRAMFrames(sim),
                "hits", sim.getHits(),
                "faults", sim.getFaults()
        );
    }

    // Convert RAM in list of IDs for frontend
    private List<Integer> getRAMFrames(Simulator sim) {
        Integer[] ramFrames = new Integer[sim.getMemory().getFrames().length];
        for (int i = 0; i < sim.getMemory().getFrames().length; i++) {
            if (sim.getMemory().getFrames()[i] != null) {
                ramFrames[i] = sim.getMemory().getFrames()[i].getId();
            } else {
                ramFrames[i] = -1; // frame gol
            }
        }
        return List.of(ramFrames);
    }
}
