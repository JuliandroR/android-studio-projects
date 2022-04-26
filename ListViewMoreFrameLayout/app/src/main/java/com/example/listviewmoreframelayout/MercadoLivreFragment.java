package com.example.listviewmoreframelayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MercadoLivreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MercadoLivreFragment extends Fragment {

    WebView ml;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MercadoLivreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MercadoLivreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MercadoLivreFragment newInstance(String param1, String param2) {
        MercadoLivreFragment fragment = new MercadoLivreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mercado_livre, container, false);

        ml = (WebView) v.findViewById(R.id.AmazonView);

        WebSettings ws = ml.getSettings();

        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        ml.setWebViewClient(new WebViewClient());

        ml.loadUrl("https://www.mercadolivre.com.br/");

        return v;
    }
}