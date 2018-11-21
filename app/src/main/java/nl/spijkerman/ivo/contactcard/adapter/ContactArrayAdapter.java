package nl.spijkerman.ivo.contactcard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import nl.spijkerman.ivo.contactcard.R;
import nl.spijkerman.ivo.contactcard.controller.ContactController;
import nl.spijkerman.ivo.contactcard.model.Contact;

public class ContactArrayAdapter extends ArrayAdapter<Contact> {
    public ContactArrayAdapter(Context context, int resource, Contact[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = ContactController.INSTANCE.getById(position);

        if (convertView == null)
            convertView = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_item_contact, null);

        TextView name = convertView.findViewById(R.id.text_view_name);
        name.setText(contact.name.toString());

        TextView email = convertView.findViewById(R.id.text_view_email);
        email.setText(contact.email);

        return convertView;
    }
}
