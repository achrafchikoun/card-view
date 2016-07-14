package com.example.mac.cardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", "Marrakech"));
        persons.add(new Person("Lavery Maiss", "25 years old", "Casablanca"));
        persons.add(new Person("Lillie Watts", "35 years old", "Agadir"));

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        RVAdapter rva = new RVAdapter(persons);
        recyclerView.setAdapter(rva);
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", "Marrakech"));
        persons.add(new Person("Lavery Maiss", "25 years old", "Casablanca"));
        persons.add(new Person("Lillie Watts", "35 years old", "Agadir"));
    }

    public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

        List<Person> personsList;

        RVAdapter(List<Person> persons){
            personsList = persons;
        }

        @Override
        public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item, parent, false);
            PersonViewHolder pvh = new PersonViewHolder(v);
            return pvh;
        }

        @Override
        public void onBindViewHolder(PersonViewHolder holder, int position) {
            holder.personName.setText(personsList.get(position).getName());
            holder.personAge.setText(personsList.get(position).getAge());
            holder.personCity.setText(personsList.get(position).getCity());
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

        @Override
        public int getItemCount() {
            return personsList.size();
        }

        public class PersonViewHolder extends RecyclerView.ViewHolder {
            CardView cv;
            TextView personName;
            TextView personAge;
            TextView personCity;

            PersonViewHolder(View itemView) {
                super(itemView);
                cv = (CardView)itemView.findViewById(R.id.cv);
                personName = (TextView)itemView.findViewById(R.id.person_name);
                personAge = (TextView)itemView.findViewById(R.id.person_age);
                personCity = (TextView)itemView.findViewById(R.id.person_city);
            }
        }

    }
}
