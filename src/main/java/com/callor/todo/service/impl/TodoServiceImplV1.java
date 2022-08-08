package com.callor.todo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;

@Service
public class TodoServiceImplV1 implements TodoService{

	private TodoDao todoDao;

	public TodoServiceImplV1(TodoDao todoDao) {
		this.todoDao = todoDao;
	}
	
	@Override
	public void create_todo_table() {
		todoDao.create_todo_table();
	}

	@Override
	public List<TodoVO> selectAll() {
		return todoDao.selectAll();
	}

	@Override
	public TodoVO findById(Long id) {
		return todoDao.findById(id);
	}

	@Override
	public int insert(TodoVO vo) {
		
			
			return 0;
	}

	@Override
	public int insertTodo(String t_content, String t_comp) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		TodoVO todoVO = TodoVO.builder().t_sdate(dayFormat.format(date))
							  .t_stime(timeFormat.format(date)).t_content(t_content).build();
		
//		if(t_comp == "완료") {
//			todoVO = TodoVO.builder().t_sdate(dayFormat.format(date))
//					  .t_stime(timeFormat.format(date)).build();
//		}
		
		return todoDao.insert(todoVO);
	
	}
	
	@Override
	public int update(TodoVO vo) {
		todoDao.update(vo);
		return 0;
	}

	@Override
	public int delete(Long id) {
		todoDao.delete(id);
		return 0;
	}

	@Override
	public TodoVO findById(long t_seq) {
		return todoDao.findById(t_seq);
	}

	@Override
	public int insertTodo(String t_content) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
