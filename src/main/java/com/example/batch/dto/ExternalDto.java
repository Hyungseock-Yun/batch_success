package com.example.batch.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

@Getter
@Setter
public class ExternalDto implements Serializable {
  private static final long serialVersionUID = 1L;
  int exlSeq = 0;	// 외부연동 시퀀스 넘버
  int scriptNum = 0;	// 매체 스크립트 고유번호
  String zoneID = "";		// 연동사 지면별 고유번호
  String mediaID = "";		// 매체사 ID
  String externalID;   // 연동사 ID
  String externalName;  // 연동사 이름
  String sendCode = ""; // 송출 구분 코드 (01:송출, 02:수신, 03:미노출)
  String useYN;   // 지면 사용 여부
  String memo;
  String addition;
  String liveDate; // 라이브 된 날짜
  String regUserID; // 등록 담당자 ID
  String regDate;	// 등록 날짜
  String altUserID; // 수정한 담당자 ID
  String altDate; // 수정 날짜
  String sdate = "";		// 날짜 : yyyymmdd
  int media_site = 0;	// 매체 key
  String transmit = "R"; //  S: 송출 , R: 수신
  String userid = "";		// 와이더플래닛 id
  String site_code = "";	// 와이더플래닛의 사이트코드
  String ad_type = "";	// 광고 크키 ex) i250_250
  int viewcnt = 0;	// 와이더플래닛 노출
  int viewcnt_mobon = 0;	// 인라이플 노출
  int clickcnt = 0;	// 와이더플래닛 클릭
  int clickcnt_mobon = 0;	// 인라이플 클릭
  int imv = 0;		// CTR * 노출
  int passback_cnt = 0;
  float point = 0;		// 매체비
  String gubun = "";		// 광고 구분자
  int totalcall = 0;	// 총 요청 CALL
  String exl_info = "";	// 외부연동 추가 정보
  String type = "";		// TYPE : 'P' 패스백
  String etc1;
  String etc2;
  String etc3;
  String etc4;
  String product = "01"; // 디폴트 배너 : 01

  String imgname;
  String imgtype;
  String site_name;


  private String dumpType; // dumpObject type

  private int partition;
  private Long offset;
  private String key;

  /**
   * 객체 생성시 boolean 값이 할당됨.
   */
  @Value("${IS_HANDLING_STATS_MOBON}")
  private boolean bHandlingStatsMobon;
  @Value("${IS_HANDLING_STATS_POINT_MOBON}")
  private boolean bHandlingStatsPointMobon;
}
