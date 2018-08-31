package com.zoran.leetcode.medium;

/**
 * �ַ������
 * https://leetcode-cn.com/submissions/detail/6325104/
 * 
 * [Solution]
 * https://blog.csdn.net/mebiuw/article/details/51156264
 */
public class Test22 {

}

/**
 * ˼·�������Ŀ��˼·�������ñ�������������˵�˼·��һ���ġ��Ӻ�����ǰ������kλ=�����ĵ�1λ���Ա������ĵ�kλ��+�����ĵ�2λ���Ա������ĵ�k-1λ
 * ��+...+, һֱ�������ĵ�kλ���Ա������ĵ�1λ������ʵ�ּ��ɣ�ע���λ��
 */
class Nice_Test22 {
	
	
    //�߾��ȳ˷�
    public String Nice_multiply(String num1, String num2) {
        char[] nums1=num1.toCharArray();
        char[] nums2=num2.toCharArray();
        int n=nums1.length,m=nums2.length,i,j,k;
        //һ����˵��������ˣ������λ��Ҳ�������ॸ�λ��֮��
        int[] result=new int[n+m];
        //ת��������
        for( i=0;i<n;i++)
            nums1[i]-='0';
        for( i=0;i<m;i++)
            nums2[i]-='0';
        //��nums2��ÿһλȥ��nums1 �ۼӵ�result
        for( i=0;i<m;i++){
            int carry=0;
            for( j=0;j<n;j++){
                result[i+j]=result[i+j]+nums2[m-1-i]*nums1[n-1-j]+carry;
                carry=result[i+j]/10;
                result[i+j]%=10;
            }
            k=i+j; //Core.  
            //�����λ
            while(carry!=0){ //carry!= 0 ���һλ�Ĵ���
                result[k]+=carry;
                carry=result[k]/10;
                result[k]%=10;
                k++;
            }
        }
        StringBuilder tmp=new StringBuilder(n+m);
        i=m+n-1;
        while(i>0 && result[i]==0)
            i--;
        while(i>=0)
            tmp.append(result[i--]);
        return tmp.toString();
    }
}