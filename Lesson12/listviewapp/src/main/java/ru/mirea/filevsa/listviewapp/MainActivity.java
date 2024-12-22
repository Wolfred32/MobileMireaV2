package ru.mirea.filevsa.listviewapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final String[] books = {
            "Война и мир", "1984", "Улисс", "Лолита",
            "Звук и ярость", "Человек-невидимка", "На маяк", "Гордость и предубеждение",
            "Божественная комедия", "Кентерберийские рассказы", "Путешествия Гулливера", "Мидлмарч",
            "Распад", "Над пропастью во ржи", "Унесенные ветром", "Сто лет одиночества",
            "Великий Гэтсби", "Уловка-22", "Возлюбленная", "Гроздья гнева",
            "Дети полуночи", "О дивный новый мир", "Миссис Дэллоуэй", "Родной сын",
            "Демократия в Америке", "О происхождении видов", "История", "Об общественном договоре",
            "Капитал", "Государь", "Исповедь", "Левиафан", "История", "Властелин колец"
    };

    private final String[] authors = {
            "Лев Толстой", "Джордж Оруэлл", "Джеймс Джойс", "Владимир Набоков",
            "Уильям Фолкнер", "Ральф Эллисон", "Вирджиния Вулф", "Джейн Остен",
            "Данте Алигьери", "Джеффри Чосер", "Джонатан Свифт", "Джордж Элиот",
            "Чинуа Ачебе", "Дж. Д. Сэлинджер", "Маргарет Митчелл", "Габриель Гарсиа Маркес",
            "Фрэнсис Скотт Фицджеральд", "Джозеф Хеллер", "Тони Моррисон", "Джон Стейнбек",
            "Салман Рушди", "Олдос Хаксли", "Вирджиния Вулф", "Ричард Райт", "Алексис Де Токвиль",
            "Чарльз Дарвин", "Геродот", "Жан-Жак Руссо", "Карл Маркс", "Николо Макиавелли",
            "Блаженный Августин", "Томас Гоббс", "Фукидид", "Джон Толкин"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initListView();
    }

    private void initListView() {
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_2, android.R.id.text1, books) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);
                text1.setText(getItem(position).toString());
                String authorString = "Нет информации";
                if (position < authors.length) authorString = authors[position];
                text2.setText(authorString);
                return view;
            };
        };
        listView.setAdapter(arrayAdapter);
    }
}