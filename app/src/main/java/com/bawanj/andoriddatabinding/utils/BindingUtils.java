package com.bawanj.andoriddatabinding.utils;


import android.databinding.BindingAdapter;

import android.widget.ImageView;

import com.bawanj.andoriddatabinding.R;
import com.squareup.picasso.Picasso;

public class BindingUtils {

    @BindingAdapter( { "bind:imageUrl" } ) // catch the url from app:imageUrl (movie_item)
    public static void loadImage( ImageView view, String url ){
        Picasso.with(view.getContext()) // create Picasso
                .load(url) // load image from url
                .error(R.mipmap.ic_launcher)// load ic_launcher if error happened
                .into(view); // put the image into view
    }

    /* So, the url of the movie poster will be passed by the declaration
     app:imageUrl="@{movie.poster}" to the loadImage method along with
    the ImageView instance, and Picasso will lazy load the image
    from the given url to the provided ImageView.

    We've used @BindingAdapter({"bind:imageUrl"}) to catch the url
    from the declaration. So BindingAdapter will help us to map
    our declaration from the xml to the appropriate method and all
    the magic behind this will be handled by android data binding library.*/
}
