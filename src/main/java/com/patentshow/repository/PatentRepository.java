package com.patentshow.repository;

import java.util.List;
import java.util.Map;


/**
 * @author unclexiao
 * @date 2018/1/9
 */
public interface PatentRepository {


    //*******数据仓库，新做*******

    /**
     * 专利申请趋势
     * 按照专利申请日，统计专利数
     */

    List getPatentNumByApplyDay();


    /**
     * 专利申请趋势
     * <p>
     * 按照专利申请季度，统计专利数
     */
    Map getPatentNumByApplySeason();


    /**
     * 专利申请趋势
     * 按照专利申请年份，统计专利数
     */
    Map getPatentNumByApplyYear();


    /**
     * 专利公开趋势
     * 按照专利申请日，统计专利数
     */

    List getPatentNumByPublicDay();


    /**
     * 专利公开趋势
     * <p>
     * 按照专利申请季度，统计专利数
     */
    Map getPatentNumByPublicSeason();


    /**
     * 专利公开趋势
     * 按照专利申请年份，统计专利数
     */
    Map getPatentNumByPublicYear();


    /**
     * 专利类型统计
     */
    Map getPatentTypeNum();


    /**
     * 研究人员趋势统计
     *
     * @return
     */
    List getResearcherNumByPublicDay();

    Map getResearcherNumByPublicSeason();


    /**
     * 技术分布统计
     */

    /**
     * 按大小组分类号统计全部
     */
    Map getPatentByTypeAndBigClassifyCode();

    Map getPatentByTypeAndSmallClassifyCode();

    /**
     * 统计某年，按大小组分类号统计专利类型
     *
     * @param year
     * @return
     */
    Map getPatentByTypeAndBigClassifyCode(int year);

    Map getPatentByTypeAndSmallClassifyCode(int year);
}
