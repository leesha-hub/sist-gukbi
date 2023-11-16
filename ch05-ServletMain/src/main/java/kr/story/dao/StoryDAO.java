package kr.story.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import kr.story.vo.StoryVO;

public class StoryDAO {
	//싱글턴 패턴
	private static StoryDAO instance = new StoryDAO();
	
	public static StoryDAO getInstance() {
		return instance;
	}
	
	private StoryDAO() {}
	
	//글 저장
	public void insert(StoryVO vo)throws Exception{
		
	}
	//글의 총 개수
	public int getCount()throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		
		
		return count;
	}
	//글 목록
	public List<StoryVO> getList(int startRow, int endRow)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StoryVO> list = null;
		String sql = null;
		
		
		
		return list;
	}
	//글 상세
	public StoryVO getStory(int num)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StoryVO vo = null;
		String sql = null;
		
		
		return vo;
	}
	//글 수정
	public void update(StoryVO vo)throws Exception{
		
	}
	//글 삭제
	public void delete(int num)throws Exception{
		
	}
	
}



