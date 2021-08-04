package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionList = institutionRepository.findAll();
        Integer bagsTotalQuantity = donationRepository.getBagsTotalQuantity();
        Integer donationCount = donationRepository.getDonationCount();
        model.addAttribute("institutionList", institutionList);
        model.addAttribute("bagsTotalQuantity", bagsTotalQuantity);
        model.addAttribute("donationCount", donationCount);
        return "index";
    }
}