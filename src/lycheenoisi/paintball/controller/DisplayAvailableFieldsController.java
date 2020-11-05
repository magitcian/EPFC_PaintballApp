package lycheenoisi.paintball.controller;
import lycheenoisi.paintball.model.Field;
import lycheenoisi.paintball.model.Timeslot;
import lycheenoisi.paintball.view.DisplayAvailableFieldsView;
import lycheenoisi.paintball.view.View;

import java.time.LocalDate;


public class DisplayAvailableFieldsController extends Controller {

    @Override
    public void run() {
        try {
            var view = new DisplayAvailableFieldsView();
            View.Action res;
            do {
                view.displayHeader();
                LocalDate date = view.askDate();
                var timeslot = Timeslot.valueOf(view.askTimeslot());
                String fightType = view.askFightType();
                var fields = Field.getAvailableFields(date, timeslot ,fightType);
                view.displayAvailableFields(fields);
                res = view.askForAction(fields.size());
                if (!fields.isEmpty() ) {
                    res = view.askForAction(fields.size());
                }
            } while (res.getAction() != 'L');
        } catch (View.ActionInterruptedException e) {
        }

    }

}