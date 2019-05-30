package study.spring.myschool.service;
import java.util.List;

import study.spring.myschool.model.StudentProfessorDepartment;
public interface StudentJoinService {
	/**
	 * 학생 상세 조회
	 * @param professor 조회할 교수의 일련번호를 담고 있는 Beans
	 * @return 조회된 데이터가 저장된 Beans
	 * @throws Exception
	 */
	public StudentProfessorDepartment getStudentJoinItem(StudentProfessorDepartment student) 
			throws Exception;
	/**
	 * 학생 목록 조회
	 * @return 조회 결과에 대한 컬렉션
	 * @throws Exception
	 */
	// -> import java.util.List;
	public List<StudentProfessorDepartment> getStudentJoinList(StudentProfessorDepartment student) 
			throws Exception;
	
	/**
	 * 전체 목록 수 조회
	 * @return 조회 결과
	 * @throws Exception
	 */
	public int getStudentCount(StudentProfessorDepartment student) throws Exception;
}