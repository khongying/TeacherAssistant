package team.bsru.lottae.teacherassistant;

/**
 * Created by Lottae on 25/2/2560.
 */

public class MyConstant {

    private String serviceLoginTA = "http://tait.bsruteam.tk/Service_php_for_android/service/ServiceLoginTa.php?";
    private String serviceCheckQRandBar ="http://tait.bsruteam.tk/Service_php_for_android/service/serviceCheckName.php?";
    private String serviceGetDateList = "http://tait.bsruteam.tk/Service_php_for_android/service/ServiceGetListDate.php?";
    private String serviceGetStuByDate ="http://tait.bsruteam.tk/Service_php_for_android/service/ServiceGetStuByDate.php?";

    public String getServiceLoginTA() {

        return serviceLoginTA;
    }

    public String getServiceCheckQRandBar() {
        return serviceCheckQRandBar;
    }

    public String getServiceGetDateList() {
        return serviceGetDateList;
    }

    public String getServiceGetStuByDate() {
        return serviceGetStuByDate;
    }
}
