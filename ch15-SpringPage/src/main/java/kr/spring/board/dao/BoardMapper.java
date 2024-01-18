package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.vo.BoardFavVO;
import kr.spring.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	//부모글
	 public List<BoardVO> selectList(Map<String,Object> map);
	 public int selectRowCount(Map<String,Object> map);
	 public void insertBoard(BoardVO board);
	 public BoardVO selectBoard(int board_num);
	 @Update("UPDATE spboard SET hit=hit+1 WHERE board_num=#{board_num}")
	 public void updateHit(int board_num);
	 public void updateBoard(BoardVO board);
	 @Delete("DELETE FROM spboard WHERE board_num=#{board_num}")
	 public void deleteBoard(int board_num);
	 @Update("UPDATE spboard SET filename='' WHERE board_num=#{board_num}")
	 public void deleteFile(int board_num);
	 
	 //좋아요
	 @Select("SELECT * FROM spboard_fav WHERE board_num=#{board_num} AND mem_num=#{mem_num}")
	 public BoardFavVO selectFav(BoardFavVO fav);
	 @Select("SELECT COUNT(*) from spboard_fav WHERE board_num=#{board_num}")
	 public int selectFavCount(int board_num);
	 public void insertFav(BoardFavVO fav);
	 public void deleteFav(BoardFavVO boardFav);
	 @Delete("DELETE FROM spboard_fav WHERE board_num=#{board_num}")
	 public void deleteFavByBoardNum(int board_num);
	 
	 //댓글
	 
	 
}










