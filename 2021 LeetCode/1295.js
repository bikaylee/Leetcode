var findNumbers = function(nums) {
    if(nums.length ===0)return 0;
    
    let evenList = nums.filter((item)=>{
        
        let a = item.toString().split('')
        if(a.length % 2 === 0)
            return a.join('');
    })
    
    return evenList.length;
};
