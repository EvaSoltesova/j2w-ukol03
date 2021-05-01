package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {

  private final List<Vizitka> vizitky;

  public VizitkaController() {
    vizitky = Arrays.asList(
            new Vizitka("Eva Šoltésová", "Questa", "Veterná 26", "917 01 Trnava", "soltesova.e@gmail.com", "0913 522 655", null ),
            new Vizitka("Ruženka Šípková", "Dlhý spánok", "Kozácka 54", "917 02 Trnava", "ruzenka.sipkova@gmail.com", null, "www.dlhyspanok.sk"),
            new Vizitka("Snehulienka Biela", "Sedem trpaslíkov", "Gondova 2", "811 02 Bratislava", null, "0910 155 211", "www.sedemtrpaslikov.sk")
    );
  }
  @GetMapping("/")
  public ModelAndView seznam() {
    ModelAndView modelAndView = new ModelAndView("seznam");
    modelAndView.addObject("vizitky", vizitky);
    return modelAndView;
  }

  @GetMapping(value = "/detail", params = "id")
  public ModelAndView detail(int id) {
    ModelAndView modelAndView = new ModelAndView("detail");
    modelAndView.addObject("vizitka", vizitky.get(id));
    return modelAndView;
  }
}
