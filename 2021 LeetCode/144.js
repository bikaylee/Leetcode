var preorderTraversal = function(root) {
    
    let emptyArr = [];
    
    function helper(root){
        if(root === null){
            return;
        } 
        
        if(root !== null){
            emptyArr.push(root.val);
        }

        helper(root.left);

        helper(root.right);

    }

    

    helper(root);

    return emptyArr;

};
