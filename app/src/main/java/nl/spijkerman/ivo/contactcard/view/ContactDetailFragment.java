package nl.spijkerman.ivo.contactcard.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.stream.Stream;

import nl.spijkerman.ivo.contactcard.R;
import nl.spijkerman.ivo.contactcard.controller.ContactController;
import nl.spijkerman.ivo.contactcard.model.Contact;

public class ContactDetailFragment extends Fragment {
    public static final String CONTACT_ID = "iuawgdiuadwg";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_detail, container, false);

        ImageView imageView = view.findViewById(R.id.image_view);
        TextView name = view.findViewById(R.id.text_view_name);
        TextView prop0 = view.findViewById(R.id.text_view_property_0);
        TextView prop1 = view.findViewById(R.id.text_view_property_1);
        TextView prop2 = view.findViewById(R.id.text_view_property_2);
        TextView prop3 = view.findViewById(R.id.text_view_property_3);
        TextView prop4 = view.findViewById(R.id.text_view_property_4);
        TextView prop5 = view.findViewById(R.id.text_view_property_5);

        if (savedInstanceState == null) {
            Stream.of(name, prop0, prop1, prop2, prop3, prop4, prop5).forEach(tv -> tv.setText(""));
        } else {
            int contactId = savedInstanceState.getInt(CONTACT_ID);
            Contact contact = ContactController.INSTANCE.getById(contactId);
            name.setText(contact.name.toString());
        }


        return view;
    }
}
