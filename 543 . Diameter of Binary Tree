var diameterOfBinaryTree = function(root) {
    
    let llength = 0;
    function depth(r){
        
        if(r === null){
            return 0;
        }
        
        let leftDiameter = depth(r.left) ;
        let rightDiameter = depth(r.right);
        
        llength = Math.max(llength, leftDiameter+rightDiameter);
        
        return Math.max(leftDiameter,rightDiameter) + 1;
    }
    
    depth(root);
    
    return llength;
};