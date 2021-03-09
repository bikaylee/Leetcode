var merge = function(nums1, m, nums2, n) {
    //maybe start the looping after the the m because we know those are the 
    //elements that are initialized
//     let nSize = 0;
//     for(let i = m; i < nums1.length; i++){
//         if(nSize < n){
//             nums1[i] = nums2[nSize];
//             nSize++;
//         }
//     }
    
//     return nums1.sort((a, b)=> a-b); //no need to return
    
    //approach it by comparing the last numbers in the nums1 and nums2
    
    let indexNums1 = m+n-1;  //starts with the last index to store the values
    let nums2Index = n-1;    //access the last index of nums2
    let nums1Index = m-1;    //access the last index of nums1
    
    //we need to loop until the size of the second array
    while(nums2Index >=0){
        if(nums1[nums1Index] > nums2[nums2Index]){
            nums1[indexNums1] = nums1[nums1Index];
            nums1Index--;
            indexNums1--;
        }
        else{
            nums1[indexNums1] = nums2[nums2Index];
            nums2Index--;
            indexNums1--;
        }
    }
    
    
};
