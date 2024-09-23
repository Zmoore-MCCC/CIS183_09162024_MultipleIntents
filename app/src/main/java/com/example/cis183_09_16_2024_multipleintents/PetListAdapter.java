package com.example.cis183_09_16_2024_multipleintents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PetListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Pet> listOfPets;

    public PetListAdapter(Context c, ArrayList<Pet> ls)
    {
        context = c;
        listOfPets = ls;
    }
    @Override
    public int getCount()
    {
        return listOfPets.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfPets.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.listview_cell, null);
        }

        //find gui elements in my custom cell
        TextView petName = view.findViewById(R.id.tv_v_cc_PetName);
        TextView petType = view.findViewById(R.id.tv_v_cc_PetType);
        TextView petAge  = view.findViewById(R.id.tv_v_cc_PetAge);

        //Get data at this particular location from our list of pets
        //we can access different elements based off the i value that is passed to this function
        Pet pet = listOfPets.get(i);

        //set the gui for the custom cell
        petName.setText(pet.getName());
        petType.setText(pet.getType());
        petAge.setText(Integer.toString(pet.getAge()));


        return view;
    }
}
