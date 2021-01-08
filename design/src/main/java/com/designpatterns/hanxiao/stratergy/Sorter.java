package com.designpatterns.hanxiao.stratergy;

/**
 * @author hx
 * @createTime 2021/1/6 21:52
 * @option
 * @description
 */
public class Sorter {


    public void sort(Comparable[] arr) {
        for (int i = 0;i< arr.length;i++){
            int minPos = i;
            for (int j = i+1;j<arr.length;j++){
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j :minPos;
            }
            swap(arr,i,minPos);
        }
    }

    static void swap(Comparable[] arr,int i,int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
