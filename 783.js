var minDiffInBST = function(root) {
    
    let min = Infinity;
    
    let prev = -Infinity;
    
    function helper(root){
        if(root === null)
            return;
        
        helper(root.left);
        
        min = Math.min(min, Math.abs(root.val- prev));
        
        prev = root.val;
        
        helper(root.right);
    }
    
    helper(root);
    
    return min;
};
