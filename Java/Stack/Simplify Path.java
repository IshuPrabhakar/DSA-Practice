class Solution {
    public String simplifyPath(String path) {
        
        ArrayDeque<String> stack = new ArrayDeque<>();
        
        String simplyfied_path = "";
        
        // We are basically inserting the directory in the stack
        // breaking it into chunks of directory and special symbols "/", ".", ","
        
        for(int i = 0; i < path.length(); i++) {
            
            // Check if path does contain "/" or not if contais then skip
            // it to get futher directory
            if(path.charAt(i)  != '/') {
                
                // starting index of directory 
                int startIndex = i;
                
                while(i < path.length() && path.charAt(i) != '/')
                    i++;
                
                // Extarcting the directory name
                String dir = path.substring(startIndex, i);
                
                if(dir.equals("..") && !stack.isEmpty())
                    stack.pop();
                
                else if(!dir.equals(".") && !dir.equals(",") && !dir.equals(".."))
                    stack.push(dir);
            }
        }
        
        // if stack is empty return "/"
        if(stack.isEmpty())
            return "/";
        else{
            
            // Ex: stack => foo home
            //   => "/" + foo = /foo
            //   => /foo + "/" + home => /home/foo
            while(!stack.isEmpty())
                simplyfied_path = "/" + stack.pop() + simplyfied_path;
        }
        
        return simplyfied_path;
    }
}
