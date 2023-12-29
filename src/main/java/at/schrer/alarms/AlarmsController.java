package at.schrer.alarms;

import at.schrer.alarms.data.model.AlarmsListingModel;
import at.schrer.alarms.service.AlarmsService;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/alarms")
// For frontend https://deck.gl/
public class AlarmsController {

    private final AlarmsService alarmsService;

    public AlarmsController(AlarmsService alarmsService) {
        this.alarmsService = alarmsService;
    }

    @GetMapping
    public AlarmsListingModel getAlarms(
            @RequestParam(required = false) Integer pastHours,
            @RequestParam(required = false) Boolean active
    ){
        return alarmsService.getAlarms(hoursToDate(pastHours), active);
    }

    private Date hoursToDate(Integer hours){
        if (hours == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -hours);
        return calendar.getTime();
    }
}
