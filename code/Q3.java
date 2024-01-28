import java.util.Arrays;
class Q3{
	static void show(double m1[][]){
		System.out.println(Arrays.deepToString(m1).replace("], ","]\n"));
	}
	static double[][] product(double m1[][],double m2[][]) throws ArithmeticException{
		if(m1[0].length!=m2.length)
			throw new ArithmeticException("Matrices are of inappropriate size");
		double answer[][]=new double[m1.length][m2[0].length];
		for(int i=0;i<answer.length;i++)
			for(int j=0;j<answer[0].length;j++)
				for(int k=0;k<answer[0].length;k++)
					answer[i][j]+=m1[i][k]*m2[k][j];
		return answer;
	}
	static double[][] product(double scalar,double m2[][]){
		double answer[][]=new double[m2.length][m2[0].length];
		for(int i=0;i<answer.length;i++)
			for(int j=0;j<answer[0].length;j++)
				answer[i][j]=scalar*m2[i][j];
		return answer;
	}
	static double[][] product(double m2[][],double scalar){
		return product(scalar,m2);
	}
	static double[][] sum(double m1[][],double m2[][]) throws ArithmeticException{
		if(m1.length!=m2.length || m1[0].length!=m2[0].length)
			throw new ArithmeticException("Matrices need to be of same dimension");
		double answer[][]=new double[m2.length][m2[0].length];
		for(int i=0;i<answer.length;i++)
			for(int j=0;j<answer[0].length;j++)
				answer[i][j]=m1[i][j]+m2[i][j];
		return answer;
	}
	static double[][] difference(double m1[][],double m2[][]){
		return sum(m1,product(-1.0,m2));
	}
	static double[][] transponse(double m1[][]){
		double answer[][]=new double[m1.length][m1[0].length];
		for(int i=0;i<answer.length;i++){
			for(int j=0;j<answer[0].length;j++)
				answer[i][j]=m1[j][i];
		}
		return answer;
	}
	private static double[][] cutout(double m1[][],int row,int column){
		double answer[][]=new double[m1.length-1][m1[0].length-1];
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++)
				answer[i][j]=m1[i][j];
			for(int j=column+1;j<m1[0].length;j++)
				answer[i][j-1]=m1[i][j];
		}
		for(int i=row+1;i<m1.length;i++){
			for(int j=0;j<column;j++)
				answer[i-1][j]=m1[i][j];
			for(int j=column+1;j<m1[0].length;j++)
				answer[i-1][j-1]=m1[i][j];
		}
		return answer;
	}
	static double determinant(double m1[][]) throws ArithmeticException{
		if(m1.length!=m1[0].length)
			throw new ArithmeticException("Matrix must be square.");
		if(m1.length==1)
			return m1[0][0];
		double answer=0.0;
		for(int i=0;i<m1.length;i++)
			answer+=Math.pow(-1.0,i)*m1[0][i]*determinant(cutout(m1,0,i));
		return answer;
	}
	static double[][] inverse(double m1[][]){
		double minors[][]=new double[m1.length][m1[0].length];
		for(int i=0;i<minors.length;i++){
			for(int j=0;j<minors[0].length;j++)
				minors[i][j]=Math.pow(-1.0,i+j)*determinant(cutout(m1,i,j));
		}
		return product(1/determinant(m1),minors);
	}
	public static void main(String args[]){
		double a[][]={
			{1.0,2.0,3.0},
			{4.0,5.0,5.0},
			{9.0,8.0,7.0},
		};
		double b[][]={
			{10.0,2.0,3.0},
			{12.0,6.0,5.0},
			{9.0,4.0,7.0},
		};
		System.out.println("a=");
		show(a);
		System.out.println("b=");
		show(b);
		System.out.println("|a|="+determinant(a));
		System.out.println("a⁻¹=");
		show(inverse(a));
		System.out.println("aᵗ=");
		show(transponse(a));
		System.out.println("a+b=");
		show(sum(a,b));
		System.out.println("axb=");
		show(product(a,b));
	}
}
