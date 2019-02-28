package nl.spijkerman.ivo.contactcard.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import nl.spijkerman.ivo.contactcard.R;
import nl.spijkerman.ivo.contactcard.controller.ImageDownloader;
import nl.spijkerman.ivo.contactcard.model.Contact;
import nl.spijkerman.ivo.contactcard.model.Location;

public class ContactDetailFragment extends Fragment {

    private ImageView imageView;
    private TextView name;
    private TextView prop0;
    private TextView prop1;
    private TextView prop2;
    private TextView prop3;
    private TextView prop4;
    private TextView prop5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_detail, container, false);

        imageView = view.findViewById(R.id.image_view);
        name = view.findViewById(R.id.text_view_name);
        prop0 = view.findViewById(R.id.text_view_property_0);
        prop1 = view.findViewById(R.id.text_view_property_1);
        prop2 = view.findViewById(R.id.text_view_property_2);
        prop3 = view.findViewById(R.id.text_view_property_3);
        prop4 = view.findViewById(R.id.text_view_property_4);
        prop5 = view.findViewById(R.id.text_view_property_5);

        return view;
    }

    public void drawFor(Contact contact) {
        ImageDownloader id = new ImageDownloader(imageView);
        id.execute(contact.picture.large);


        Location location = contact.location;
        name.setText(contact.name.toString());
        prop0.setText(contact.email);
        prop1.setText(location.street);
        prop2.setText(location.postcode.toString());
        prop3.setText(location.city);
        prop4.setText(contact.phone);
        prop5.setText(contact.cell);
    }
}
