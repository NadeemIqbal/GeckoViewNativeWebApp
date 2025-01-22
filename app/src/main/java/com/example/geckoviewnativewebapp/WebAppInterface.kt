//package com.example.geckoviewnativewebapp
//
//import android.content.Context
//import android.os.Bundle
//import android.util.Log
//import android.webkit.JavascriptInterface
//import android.webkit.WebView
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import com.fatron.network_module.utils.T
//import com.merigari.customer.R
//import com.merigari.customer.viewmodel.DashboardViewModel
//
//class WebAppInterface(
//    private val context: Context,
//    private val webView: WebView,
//    private val mViewModel: DashboardViewModel?,
//    private val fragment: Fragment
//
//) {
//
//    @JavascriptInterface
//    fun externalLinkAllowed(link: Boolean, url: String, backURL: String) {
//        // Log.e(WebViewActivity.TAG, "Cancel Url + $link $backURL")
//        //  WebViewActivity.backUrl = backURL
//        //    WebViewActivity.cancelEnable = link
//
////        webView.post {
////            webView.loadUrl(url)
////           // mViewModel._cancelButton.value = link
////        }
//
//    }
//
//
////    @JavascriptInterface
////    fun notificationIconClicked(hello: String) {
////        fragment.findNavController().navigate(R.id.notificationListingFragment)
////    }
//
//    @JavascriptInterface
//    fun promoVideoBackHandler(hello: String){
//         fragment.findNavController().popBackStack()
//    }
//
//
//
//    @JavascriptInterface
//    fun helpScreenCall(hello: String){
//        fragment.findNavController().navigate(R.id.helpFragment)
//    }
//
//
//
//    @JavascriptInterface
//    fun scanQrCall(hello: String){
//        mViewModel?.openQRScanner?.postValue(true)
//    }
//
//    @JavascriptInterface
//    fun logoutCall(hello: String){
//        mViewModel?.openLogoutDialog?.postValue(true)
//
//    }
//
//    @JavascriptInterface
//    fun savedLocationScreenCall(hello: String){
//        fragment.findNavController().navigate(R.id.savedLocationsFragment)
//    }
//
//    @JavascriptInterface
//    fun termAndConditionCall(hello: String){
//        fragment.findNavController().navigate(R.id.termsSimpleFragment)
//    }
//
//    @JavascriptInterface
//    fun profileScreenCall(hello: String){
//        val b = Bundle()
//        b.putBoolean("fromProfile", true)
//        fragment.findNavController().navigate(R.id.myProfileFragment, b)
//    }
//
//    @JavascriptInterface
//    fun ContactClicked(hello: String){
//        mViewModel?.whatsAppNumber?.postValue(hello)
//    }
//
//    @JavascriptInterface
//    fun loadDetailWhatsapp(hello: String){
//        mViewModel?.loadDetailWhatsappLiveData?.postValue(hello)
//    }
//
//    @JavascriptInterface
//    fun loadDetailPhone(hello: String){
//        mViewModel?.loadDetailPhoneLiveData?.postValue(hello)
//    }
//
//
//    @JavascriptInterface
//    fun chatWhatsapp(hello: String){
//           // context.T(hello)
//        mViewModel?.chatWhatsapp?.postValue(hello)
//    }
//
//    @JavascriptInterface
//    fun chatPhone(hello: String){
//      //  context.T(hello)
//        mViewModel?.chatPhone?.postValue(hello)
//    }
//
//    @JavascriptInterface
//    fun networkWhatsapp(hello: String){
//        //context.T(hello)
//        mViewModel?.networkWhatsapp?.postValue(hello)
//    }
//
//    @JavascriptInterface
//    fun networkPhone(hello: String){
//      //  context.T(hello)
//        mViewModel?.networkPhone?.postValue(hello)
//    }
//
//    @JavascriptInterface
//    fun UploadedDocuments(url: String){
//
//        mViewModel?.downloadPDFUrl?.postValue(url)
//
//    }
//
//
//    @JavascriptInterface
//    fun activeLoadPhone(hello: String){
//      //  context.T(hello)
//        mViewModel?.activeLoadPhoneLiveData?.postValue(hello)
//    }
//
//    @JavascriptInterface
//    fun activeLoadWhatsapp(hello: String){
//        //context.T(hello)
//        mViewModel?.activeLoadWhatsappLiveData?.postValue(hello)
//    }
//
//
//
//    @JavascriptInterface
//    fun voiceRecordStart(start: String){
//        mViewModel?.startAudioRecord?.postValue(start)
//    }
//
//    @JavascriptInterface
//    fun voiceRecordStop(stop: String){
//        mViewModel?.stopAudioRecord?.postValue(stop)
//    }
//
//    @JavascriptInterface
//    fun closeRecording(value : String){
//     //   context.T(value)
//        mViewModel?.closeRecording?.postValue(value)
//    }
//
//    @JavascriptInterface
//    fun accessCamera(hello: String){
//       mViewModel?.openCamera?.postValue(hello)
//    }
//
//    @JavascriptInterface
//    fun accessGallery(hello: String){
//        mViewModel?.galleryEvent?.postValue(hello)
//    }
//
//    @JavascriptInterface
//    fun accessDoc(hello: String){
//        mViewModel?.openDoc?.postValue(hello)
//    }
//
//    @JavascriptInterface
//    fun requestContact(hello: String){
//        mViewModel?.sendContacts?.postValue(hello)
//    }
//
//
//    @JavascriptInterface
//    fun webviewLogout(hello: String){
//    //    if(check){
//        //    context.T(check.toString())
//            Log.d("zxcvb", hello)
//            mViewModel?.webViewLogout?.postValue(true)
//    //    }
//    }
//
//
//
//    @JavascriptInterface
//    fun loadDetailPDF(url : String? = null){
//        mViewModel?.loadDetailPDFUrl?.postValue(url)
//    }
//
//
//
////    @JavascriptInterface
////    fun loadDetailPDF(url : String){
////        mViewModel?.loadDetailPDFUrl?.postValue(url)
////    }
//
//
//    @JavascriptInterface
//    fun voiceRecordDelete(item : String){
//        //context.T(item)
//    }
//
//    @JavascriptInterface
//    fun dashboardGenerateReport(url :String){
//       // context.T(url)
//        mViewModel?.dashboardGenerateReport?.postValue(url)
//    }
//
//
//    @JavascriptInterface
//    fun exitApp(exit: String){
//  //      context.T(exit)
//        mViewModel?.finalBackButtonExit?.postValue(exit)
//    }
//
//    @JavascriptInterface
//    fun clearCache(value : String){
//        //context.T(value)
//        mViewModel?.clearCache?.postValue(true)
//    }
//
//    @JavascriptInterface
//    fun mixpanelEventSend(eventName : String){
//    //    context.T(eventName)
//        mViewModel?.mixpanelEventSend?.postValue(eventName)
//
//    }
//
//    @JavascriptInterface
//    fun OpenWebLink(url : String){
//      //  context.T(url)
//        mViewModel?.openWebLink?.postValue(url)
//
//    }
//
//    @JavascriptInterface
//    fun ShareViaWhatsapp(url : String){
//     //   context.T(url)
//        Log.d("asdfg", url)
//        mViewModel?.shareViaWhatsapp?.postValue(url)
//
//    }
//
//}
