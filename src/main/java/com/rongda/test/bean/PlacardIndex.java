package com.rongda.test.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Gecco(matchUrl = "http://www.csrc.gov.cn/pub/zjhpublic/G00306202/201712/t20171229_330048.htm?keywords=",
        pipelines = "placardIndex")
public class PlacardIndex implements HtmlBean {

    /**
     * 公告名称
     */
    @Text
    @HtmlField(cssPath = "#lTitle")
    private String title;
    /**
     * 索引号
     */
    @Text
    @HtmlField(cssPath = "#headContainer > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(1)")
    private String index;

    /**
     * 发布机构#headContainer > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(1) > span
     */
    @Text
    @HtmlField(cssPath = "#headContainer > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(1) > span")
    private String jigou;

    /**
     * 文号
     */
    @Text
    @HtmlField(cssPath = "#headContainer > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(1) > span")
    private String wenhao;

    /**
     * 分类
     */
    @Text
    @HtmlField(cssPath = "#lSubcat")
    private String type;

    /**
     * 发布时间
     */
    @Text
    @HtmlField(cssPath = "#headContainer > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > span")
    private String date;

    /**
     * 主题词
     */
    @Text
    @HtmlField(cssPath = "#headContainer > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > span")
    private String theme;


    /**
     *  审核委员/发行人
     *  new CopyOnWriteArrayList<ShenheInfoDao>{new ShenheInfoDao,new ShenheInfoDao,new ShenheInfoDao};
     */


    @Html //#TRS_AUTOADD_1514549380640 > div > p:nth-child(3)
    @HtmlField(cssPath = "#TRS_AUTOADD_1514549380640 > div > p:nth-child(3),p:nth-child(4)," +
            "p:nth-child(8),p:nth-child(9),p:nth-child(13),p:nth-child(14)")
    String member;

    @Html   //#TRS_AUTOADD_1514549380640 > div > p:nth-child(6) > span  #TRS_AUTOADD_1514549380640 > div > p:nth-child(11) > span
    @HtmlField(cssPath = "#TRS_AUTOADD_1514549380640 > div > p:nth-child(6),p:nth-child(11),p:nth-child(16)")
    String issuedName;

    private List<ShenheInfo> ShenheInfo;

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = htmlToText(member);
    }
    private String htmlToText(String str){
        str = str.replaceAll("　　　　",",")
                .replaceAll("　　",",")
                .replaceAll("\\n",";")
                .replaceAll("　","")
                .replaceAll("</span>","")
                .replaceAll("<span>","")
                .replaceAll(",;,",";")
                .replaceAll(";,",",")
        ;
        if (str.startsWith(",")) str = str.substring(1);
        if (str.endsWith(",")) str = str.substring(0,str.length()-1);
        return str;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getIssuedName() {
        return issuedName;
    }

    public void setIssuedName(String issuedName) {
        this.issuedName = htmlToText(issuedName).replaceAll(",",";");
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getJigou() {
        return jigou;
    }

    public void setJigou(String jigou) {
        this.jigou = jigou;
    }

    public String getWenhao() {
        return wenhao;
    }

    public void setWenhao(String wenhao) {
        this.wenhao = wenhao;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PlacardIndex{" +
                "title='" + title + '\'' +
                ", index='" + index + '\'' +
                ", jigou='" + jigou + '\'' +
                ", wenhao='" + wenhao + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", theme='" + theme + '\'' +
                ", member='" + member + '\'' +
                ", issuedName='" + issuedName + '\'' +
                ", ShenheInfoDao=" + ShenheInfo +
                '}';
    }

    public List<com.rongda.test.bean.ShenheInfo> getShenheInfo() {
        return ShenheInfo;
    }

    public void setShenheInfo(List<com.rongda.test.bean.ShenheInfo> shenheInfo) {
        ShenheInfo = shenheInfo;
    }

}
