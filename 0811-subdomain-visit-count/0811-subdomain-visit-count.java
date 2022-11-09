/**
Split each array element and get the first value after spliting with the space
Split the remaining part and the value of each of the parts will be the first element


 */

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {

        ArrayList<String> finalResult = new ArrayList<>();

        HashMap<String, Integer> frequency = new HashMap<>();

        for(int i = 0; i < cpdomains.length; i++) {
            int val = Integer.parseInt(cpdomains[i].split(" ")[0]);
            String domain = cpdomains[i].split(" ")[1];
            ArrayList<String> allDomains = new ArrayList<>();
            allDomains = getSubDomains(domain);
            for (String dom : allDomains) {
                frequency.put(dom, frequency.getOrDefault(dom, 0) + val);
            }
        }

        for (String dom : frequency.keySet()) {
            String temp = frequency.get(dom) + " " + dom;
            finalResult.add(temp);
        }

        return finalResult;

    }
    public ArrayList<String> getSubDomains(String domain) {
        ArrayList<String> result = new ArrayList<>();
        List<String> domArr = Arrays.asList(domain.split("[.]"));
        int size = domArr.size();
        
        for (int i = 0; i < size; i++) {
            String sub = String.join(".", domArr.subList(i, size));
            result.add(sub);
        }
        return result;
    }
}