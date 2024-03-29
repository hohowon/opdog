package com.opdoghj.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.opdoghoho.doginfo.DogB;
import com.opdoghoho.doginfo.dogInfo;
import com.opdoghw.centerinfo.DBManager_khw;

public class MainDAO {
	
	
	
	public static void listLoading(HttpServletRequest request, HttpServletResponse response) {

		Date currenDate = new Date();


		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(currenDate);
		calendar2.add(calendar2.DAY_OF_MONTH, -10);
		Date dDay = calendar2.getTime();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dDay);
		calendar.add(calendar.DAY_OF_MONTH, +5);
		Date searchEdt = calendar.getTime();

		System.out.println(currenDate);
		System.out.println(dDay);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		int noticeEdt = Integer.parseInt(dateFormat.format(dDay));
		int searchEdtInt = Integer.parseInt(dateFormat.format(searchEdt));

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dogInfo where d_noticeEdt >= ? and d_noticeEdt < ?";

		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noticeEdt);
			pstmt.setInt(2, searchEdtInt);
			rs = pstmt.executeQuery();
			ArrayList<DogB> doglist = new ArrayList<DogB>();
			DogB d = null;
			while (rs.next()) {
				d = new DogB();
				int noticeEdtInt = rs.getInt("d_noticeEdt");
				String noticeEdtStr = String.valueOf(noticeEdtInt);
				Date noticeEdtDate = dateFormat.parse(noticeEdtStr);
				d.setNo(rs.getString("d_desertionNo"));
				System.out.println(rs.getString("d_desertionNo"));
				d.setAge(rs.getString("d_age"));
				d.setKindCd(rs.getString("d_kindCd"));
				d.setPopfile(rs.getString("d_popfile"));
				d.setSexCd(rs.getString("d_SexCd"));
				long diffMS = currenDate.getTime() - noticeEdtDate.getTime();
				long diffdays = 10 - (diffMS / (24 * 60 * 60 * 1000L)) % 365;
				d.setDate(noticeEdtInt);
				d.setDday(diffdays+1);
				doglist.add(d);
			}
			
			
			Comparator<DogB> comparedDate = Comparator.comparing(DogB::getDate, Comparator.naturalOrder());
			ArrayList<DogB> comparedDogList = (ArrayList<DogB>) doglist.stream().sorted(comparedDate)
					.collect(Collectors.toList());

			request.setAttribute("dog", comparedDogList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
	}

	public static void totalCountLoading(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as totalCount from dogInfo";


		try {
			con = DBManager_khw.connect();
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("totalCount");
				request.setAttribute("count", count);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}

	}

	public static void loadDetail(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dogInfo where d_desertionNO = ?";
		
		
		
		String desertionNo = request.getParameter("desertionNo");
		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, desertionNo);
			rs = pstmt.executeQuery();
			dogInfo d = null;
			if (rs.next()) {
				System.out.println("있긴 있음");
				d = new dogInfo();
				d.setAge(rs.getString("d_age"));
				System.out.println(d.getAge());
				d.setCareAddr(rs.getString("d_careaddr"));
				d.setCareNm(rs.getString("d_careNm"));
				d.setCareTel(rs.getString("d_careNm"));
				d.setChargeNm(rs.getString("d_chargeNm"));
				d.setDesertionNo(rs.getString("d_desertionNo"));
				d.setFilename(rs.getString("d_filename"));
				d.setHappenDt(rs.getString("d_happenDt"));
				d.setKindCd(rs.getString("d_kindcd"));
				d.setNeuterYn(rs.getString("d_neuterYn"));
				d.setNoticeEdt(rs.getInt("d_noticeEdt"));
				d.setNoticeNo(rs.getString("d_noticeNo"));
				d.setOfficeTel(rs.getString("d_officetel"));
				d.setOrgNm(rs.getString("d_orgNm"));
				d.setPopfile(rs.getString("d_popFile"));
				d.setProcessState(rs.getString("d_Processstate"));
				d.setSexCd(rs.getString("d_SexCd"));
				d.setWeight(rs.getString("d_weight"));
			}
			System.out.println(d);
			System.out.println("1번 완료");
		    String dog = new Gson().toJson(d);

			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(dog);
			System.out.println("2번 완료");

			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_khw.close(con, pstmt, rs);
		}
		
	}
}
