package com.zoran.leetcode.simple2;

/**
 * ��������
 * https://leetcode-cn.com/submissions/detail/3179031/
 */
public class Test47 {

	//��������Ϊ�ڴ���1����Ȼ���У�����1�����������ⲻ������������
	public static void main(String[] args) {
		System.out.println(Zqs_countPrimes(15));
	}
	
	/**
	 * ��ʱ : 499979 
	 */
    public static int countPrimes(int n) {
        if(n == 1) return 0;
        
        int count = 0;
        for(int i = 2;i <n; i++) { //���
            if(i ==2) {
                count++;
                continue;
            }
            
            for(int j =2; j < i; j++) {
                if(i%j == 0) {
                    break;
                }
                
                if(j == i -1) {
                    count++;
                }
            }
        }
        
        return count;
    }

    /**
     * 1.�����������Ϊ����
     * 2.��������������,���Էֽ����ӵ���,������Էֽ�, ���1
     */
    public static int Nice_countPrimes(int n) {
            if (n <= 2) {
               return 0;
           }
           boolean[] notPrimes = new boolean[n];
           int cnt = n / 2;//��������������������
           for (int i = 3; i * i < n; i += 2) {//ֻ�ж���������� nice_core:  3*5 =15, 5*3 =15, ������3��ʱ����ȹ��˵�3*5�����
               if (notPrimes[i]) continue;//����Ѿ���Ϊ���� ���ٱ�Ǻͼ���
               for (int j = i * i; j < n; j += 2 * i) {  //nice_core: j = i * (i +2*n) ��ʽ�ֽ�
                   if (!notPrimes[j]){
                       cnt--;
                       notPrimes[j] = true;
                   }
               }

           }
           return cnt;
    }
    
    public static int Zqs_countPrimes(int n) {
        if (n <= 1 || n==2) return 0;
        
        boolean[] notPrimes = new boolean[n];
        int count = n/2;
        for(int i =3; i*i < n; i = i+2) { //core i*i
            if(notPrimes[i]) continue; //�Ѿ�������
            
            for(int j = i *i; j < n; j += i*2) { //core j = i*(i+2*n)
                if(!notPrimes[j]) { //core 2�����Ĺ�����ʱ, Ҫ���ж�, ���� 9��25, ֵ3*(3+72) = 225 ,5*(5+40) = 225  �����ظ�
                    notPrimes[j] = true;
                    count--;
                }
            }
        }
        
        return count;
    }
}
