package com.example.practicajetpack

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_navegador.*
import java.time.LocalDate


class navegador : Fragment() {
    //Private
    private val BASE_URL ="https://google.com"
    private val SEARCH_PATH = "/search?q="
    var estado =true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(estado) {
            override fun handleOnBackPressed() {
                if(webView.canGoBack()){
                    webView.goBack()
                }else{
                     val directions3 = navegadorDirections.actionNavegadorToPrincipal()
                    findNavController().navigate(directions3)
                }

                // in here you can do logic when backPress is clicked
            }
        })

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_navegador, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Search

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {

                query?.let {
                    if(URLUtil.isValidUrl(it)){
                        //Es una url
                        webView.loadUrl(it)
                    }else{
                        //No es una url
                        webView.loadUrl("$BASE_URL$SEARCH_PATH$it")
                    }
                }

                return false
            }
        })

        //Refresh
        swipeRefresh.setOnRefreshListener {
            webView.reload()
        }

        //WebView
        webView.webChromeClient = object  : WebChromeClient(){

        }

        webView.webViewClient = object  : WebViewClient(){

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return  false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                swipeRefresh.isRefreshing = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                swipeRefresh.isRefreshing=false
            }

        }

        val settings = webView.settings
        settings.javaScriptEnabled=true

        webView.loadUrl(BASE_URL)
    }

  }