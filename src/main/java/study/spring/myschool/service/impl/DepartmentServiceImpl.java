package study.spring.myschool.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.myschool.model.Department;
import study.spring.myschool.model.Professor;
import study.spring.myschool.model.Student;
import study.spring.myschool.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	@Autowired
	SqlSession sqlSession;

	/** 생성자를 통한 객체 생성 */
	public DepartmentServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void addDepartment(Department department) throws Exception {
		try {
			int result = sqlSession.insert("DepartmentMapper.insertDepartmentItem", department);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 데이터가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 저장에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void editDepartment(Department department) throws Exception {
		try {
			int result = sqlSession.update("DepartmentMapper.updateDepartmentItem", department);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("변경된 데이터가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void deleteDepartment(Department department) throws Exception {
		try {
			Student student = new Student();
			student.setDeptno(department.getDeptno());
			Professor professor = new Professor();
			professor.setDeptno(department.getDeptno());
			sqlSession.delete("StudentMapper.deleteDepartmentItem", student);
			sqlSession.delete("ProfessorMapper.deleteDepartmentItem", professor);
			
			int result = sqlSession.delete("DepartmentMapper.deleteDepartmentItem", department);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("삭제된 데이터가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public Department getDepartmentItem(Department department) throws Exception {
		Department result = null;

		try {
			result = sqlSession.selectOne("DepartmentMapper.selectDepartmentItem", department);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public List<Department> getDepartmentList(Department department) throws Exception {
		List<Department> result = null;

		try {
			result = sqlSession.selectList("DepartmentMapper.selectDepartmentList", department);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int getDepartmentCount(Department department) throws Exception {
		int result = 0;

		try {
			result = sqlSession.selectOne("DepartmentMapper.selectDepartmentCount", department);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public List<Department> getDepartmentList2(Department department) throws Exception {
		List<Department> result = null;

		try {
			result = sqlSession.selectList("DepartmentMapper.selectProfessorList", department);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

}
