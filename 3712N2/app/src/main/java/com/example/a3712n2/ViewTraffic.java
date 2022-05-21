package com.example.a3712n2;

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
 * Use the {@link ViewTraffic#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewTraffic extends Fragment {

    WebView webview;
    String url;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ViewTraffic() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewTraffic.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewTraffic newInstance(String param1, String param2) {
        ViewTraffic fragment = new ViewTraffic();
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
        View view =  inflater.inflate(R.layout.fragment_view_traffic, container, false);

        //Recebendo conteúdo do Bundle
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            url = bundle.getString("url"); //acesso pela key.
        }

        //Configurando o webView
        webview = view.findViewById(R.id.view_traffic);

        //receber a entidade de configuração
        WebSettings ws = webview.getSettings();

        //setar valores JavaScript e Zoom;
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        //acessar a URL
        webview.loadUrl(url);

        webview.setWebViewClient(new WebViewClient());

        return view;
    }
}