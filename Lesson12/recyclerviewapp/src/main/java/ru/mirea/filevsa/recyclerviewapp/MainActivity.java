package ru.mirea.filevsa.recyclerviewapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Event> events = getListData();
        RecyclerView recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new EventAdapter(events));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private List<Event> getListData() {
        List<Event> events = new ArrayList<>();
        Event northernWar = new Event("Северная война", "(22 февраля) 1700 — (10 сентября) 1721",
                "Россия возвращает выход к Балтийскому морю и провозглашается империей;\n" +
                        "Швеция теряет свои владения в Ингрии, Ливонии, Эстляндии, Приладожье, большей части Померании и навсегда утрачивает статус великой державы.",
                "event_northern_war");
        Event ruspolWar = new Event("Русско-польская война", "(18 мая) — (27 июля) 1792",
                "Второй раздел Речи Посполитой;\n" +
                        "Воссоединение большей части древнерусских земель;\n" +
                        "Отмена большей части реформ Четырёхлетнего сейма.",
                "event_rus_pol_war");
        Event sssrpolWar = new Event("Советско-польская война", "(28 января) 1919 — (18 марта) 1921",
                "Победа Польши, захват западной Белоруссии и западной Украины, ликвидация Литбела;\n" +
                        "Рижский мирный договор.",
                "event_sssr_pol_war");
        Event kurskayaBattle = new Event("Курская битва", "(5 июля) — (23 августа) 1943",
                "Победа Красной армии\n" +
                        "Германия утратила возможность проводить крупные стратегические наступательные операции на Восточном фронте\n" +
                        "Стратегическая инициатива окончательно перешла к Красной армии.",
                "event_kurskaya_battle");
        Event coldWar = new Event("Холодная война", "(5 марта) 1946 — (26 декабря) 1991",
                "Прекращение противостояния СССР и США;\n" +
                        "Распад социалистического лагеря —\n" +
                        "Распад СССР,\n" +
                        "Прекращение действия Варшавского договора,\n" +
                        "Распад СЭВ,\n" +
                        "Воссоединение Германии;\n" +
                        "Расширение ЕС и НАТО.",
                "event_cold_war");

        events.add(northernWar);
        events.add(ruspolWar);
        events.add(sssrpolWar);
        events.add(kurskayaBattle);
        events.add(coldWar);

        return events;
    }
}