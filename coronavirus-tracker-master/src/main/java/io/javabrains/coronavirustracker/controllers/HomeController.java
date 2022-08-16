package io.javabrains.coronavirustracker.controllers;

import io.javabrains.coronavirustracker.models.DeathStats;
import io.javabrains.coronavirustracker.models.LocationStats;
import io.javabrains.coronavirustracker.services.CoronaVirusDataService;
import io.javabrains.coronavirustracker.services.DeathDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;
    @Autowired
    DeathDataService deathDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        List<DeathStats> deathStats = deathDataService.getDeathStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();


        int totalReportedDeaths = deathStats.stream().mapToInt(stat -> stat.getLatestTotalDeaths()).sum();
        int totalNewDeaths = deathStats.stream().mapToInt(stat -> stat.getDiffDeathsFromPrevDay()).sum();

        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);

        model.addAttribute("deathStats", deathStats);
        model.addAttribute("totalReportedDeaths", totalReportedDeaths);
        model.addAttribute("totalNewDeaths", totalNewDeaths);

        return "home";
    }
}
