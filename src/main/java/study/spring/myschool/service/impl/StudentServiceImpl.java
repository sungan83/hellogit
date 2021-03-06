package study.spring.myschool.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.myschool.model.Student;
import study.spring.myschool.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	/** 처리 결과를 기록할 Log4J 객체 생성 */
	// --> import org.apache.logging.log4j.Logger;
	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	/** MyBatis */
	// --> import org.apache.ibatis.session.SqlSession
	@Autowired
	SqlSession sqlSession;

	/** 생성자를 통한 객체 생성 */
	public StudentServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void addStudent(Student student) throws Exception {
		try {
			int result = sqlSession.insert("StudentMapper.insertStudentItem", student);
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
	public void editStudent(Student student) throws Exception {
		try {
			int result = sqlSession.update("StudentMapper.updateStudentItem", student);
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
	public void deleteStudent(Student student) throws Exception {
		try {
			int result = sqlSession.delete("StudentMapper.deleteStudentItem", student);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			System.out.println("삭제할거 없음.");
			return;
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			System.out.println("삭제실패");
			return;
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public Student getStudentItem(Student student) throws Exception {
		Student result = null;

		try {
			result = sqlSession.selectOne("StudentMapper.selectStudentItem", student);
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
	public List<Student> getStudentList(Student student) throws Exception {
		List<Student> result = null;

		try {
			result = sqlSession.selectList("StudentMapper.selectStudentList", student);
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
	public void deleteDepartment(Student student) throws Exception {
		try {
			int result = sqlSession.delete("StudentMapper.deleteDepartmentItem", student);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			System.out.println("삭제할거 없음.");
			return;
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			System.out.println("삭제실패");
			return;
		} finally {
			sqlSession.commit();
		}

	}

}
