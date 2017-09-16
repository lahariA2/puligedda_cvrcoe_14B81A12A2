package studentgroup;

import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 *
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation{

	private Student[] students;
        private int length;

	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
                this.length=length;
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		try
		{
		if(students==null)
            throw new IllegalArgumentException();
        else
            this.students=students;
		}
		catch(Exception e)
		{
            e.printStackTrace();
		}

	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		try
		{
            if(index<0 || index>=students.length)
            {   throw new IllegalArgumentException();
            }
            else
            {   return students[index];
            }
		}
        catch(Exception e)
        {   e.printStackTrace();
        }
		return null;
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		try
		{
            if(student==null || index<0 || index>=students.length)
            {   throw new IllegalArgumentException();
            }
            else
                students[index]=student;
		}
		catch(Exception e)
		{
            e.printStackTrace();
		}

	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
    try
		{
            if(student==null)
                throw new IllegalArgumentException();
                length++;
               for(int i=length-1;i>=0;i--)
                {
                    students[i+1]=students[i];
                }
                students[0]=student;
		}
		catch(Exception e)
		{   e.printStackTrace();
		}


	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		 try
		{
            if(student==null)
                throw new IllegalArgumentException();
                length ++;

                students[length]=student;
		}
		catch(Exception e)
		{   e.printStackTrace();
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		try
		{
            if(student==null || index<0 || index>=students.length)
            {   throw new IllegalArgumentException();
            }
            else
            { 
              length=length+1;
            
             for(int i=length-1;i>=index;i--)
                {
                    students[i+1]=students[i];
                }
                students[index]=student;

            }
		}
		catch(Exception e)
		{
            e.printStackTrace();
		}

	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		try
		{

            if( index<0 || index>=students.length)
            {   throw new IllegalArgumentException();
            }
            else
            {   for(int i=index;i<students.length;i++)
                {
                    students[i]=students[i+1];
                }
                this.length = this.length-1;
            }
		}
		catch(Exception e)
		{
            e.printStackTrace();
		}

	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		try
		{
            if(student==null)
                throw new IllegalArgumentException();

               for(int i=0;i<length;i++)
                {    if(students[i]==student)
                    {
                        remove(i);
                        break;
                    }
                     if(i==length  && students[i]!=student)
                        throw new IllegalArgumentException("Student not exist");
                }
		}
		catch(Exception e)
		{   e.printStackTrace();
		}

	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		try
		{

            if( index<0 || index>=length)
            {   throw new IllegalArgumentException();
            }
            else
            {   for(int i=index+1;i<length;i++)
                {
                    remove(i);
                }
            }
		}
		catch(Exception e)
		{
            e.printStackTrace();
		}

	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		try
		{
            if(student==null)
                throw new IllegalArgumentException();

               for(int i=0;i<length;i++)
                {    if(students[i]==student)
                    {
                        removeFromIndex(i);
                        break;
                    }
                  
                }
		}
		catch(Exception e)
		{   e.printStackTrace();
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		try
		{

            if( index<0 || index>=length)
            {   throw new IllegalArgumentException();
            }
            else
            {   for(int i=0;i<index;i++)
                {
                    remove(i);
                }
            }
		}
		catch(Exception e)
		{
            e.printStackTrace();
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here

		try
		{
            if(student==null)
                throw new IllegalArgumentException();

               for(int i=0;i<length;i++)
                {    if(students[i]==student)
                    {
                        removeToIndex(i);
                        break;
                    }

                }
		}
		catch(Exception e)
		{   e.printStackTrace();
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
      /*  for(int i=0;i<length;i++)
        {      Student tmp=new Student(0,"xyz",null,0.00);
            if(students[i+1].getAvgMark >students[i].getAvgMark)
             {   tmp=students[i];
                students[i]=students[i+1];
                students[i+1]=tmp;

             }

        }
*/
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		try
		{if(date==null)
            throw new IllegalArgumentException();
		Student[] stu=new Student[length];
		int i,j=0;
		for(i=0;i<students.length;i++)
		{
            if(students[i].getBirthDate()==date)
            {
                    stu[j]=students[i];j++;
            }
        
        if(stu!=null)
            return stu;
        
            
		}
                }
                catch(Exception e)
                        {
                        e.printStackTrace();
                        }
                return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here

		try
		{if(firstDate==null || lastDate==null)
            throw new IllegalArgumentException();
		Student[] stu=new Student[length];
		int i,j=0;
		for(i=0;i<students.length;i++)
		{
            if(students[i].getBirthDate()==firstDate)
            {   for(;i<students.length;i++)
                 {
                   stu[j]=students[i];j++;
                 if(students[i].getBirthDate()==lastDate)
                    break;
                 }
                 break;
            }}
                  if(stu!=null)
            return stu;
	}
                catch(Exception e)
                        {
                        e.printStackTrace();
                        }
                return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		try
		{   if(indexOfStudent==0)
                throw new IllegalArgumentException();

             Date d=students[indexOfStudent].getBirthDate();
            long syr=d.getYear();
            int age=(int) (2017-syr);
            return age;

		}
		catch(Exception e)
		{e.printStackTrace();
		}


		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}

