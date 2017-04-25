package ir.androiddevs.shahini.searchinlistsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saeed shahini on 2/1/2017.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
    private List<Contact> contacts=new ArrayList<>();
    private List<Contact> filteredContacts;
    private Context context;

    public ContactsAdapter(Context context){
        this.context = context;
        contacts=getData();
        filteredContacts=new ArrayList<>(contacts);
    }

    public void filter(String searchKeyword){
        searchKeyword=searchKeyword.toLowerCase();
        if (searchKeyword.isEmpty()){
            filteredContacts=new ArrayList<>(contacts);
        }else {
            filteredContacts=new ArrayList<>();
            for (int i = 0; i < contacts.size(); i++) {
                String firstName=contacts.get(i).getFirstName();
                String lastName=contacts.get(i).getLastName();
                if (firstName.toLowerCase().contains(searchKeyword) || lastName.toLowerCase().contains(searchKeyword)){
                    filteredContacts.add(contacts.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }


    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item_contact,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.bindContact(filteredContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredContacts.size();
    }

    public List<Contact> getData(){
        List<Contact> contacts=new ArrayList<>();

        Contact contact=new Contact();
        contact.setFirstName("Ali");
        contact.setLastName("Mohammadi");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Saman");
        contact.setLastName("PourAskari");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Saeed");
        contact.setLastName("Shokat");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Maryam");
        contact.setLastName("HamidNezhad");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Sara");
        contact.setLastName("Ahmadi");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Fateme");
        contact.setLastName("Eshraghi");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Pouya");
        contact.setLastName("Ahmadi");
        contacts.add(contact);

        return contacts;
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTextView;
        private TextView letterTextView;

        public ContactViewHolder(View itemView) {
            super(itemView);
            nameTextView=(TextView)itemView.findViewById(R.id.textView_itemContact_name);
            letterTextView=(TextView)itemView.findViewById(R.id.textView_itemContact_letter);
        }

        public void bindContact(Contact contact){
            nameTextView.setText(contact.getFirstName()+" "+contact.getLastName());
            char firstNameFirstChar=contact.getFirstName().charAt(0);
            letterTextView.setText(Character.toString(firstNameFirstChar));
        }
    }

}
