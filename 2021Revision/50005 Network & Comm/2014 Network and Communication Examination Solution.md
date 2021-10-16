# 2014 Network and Communication Examination Solution

*This year the OS and Network paper are merged together*

3. a. The maximum achievable throughput is
   $$
   \lambda=\frac{W}{\text{RTT}}=\frac{128\cdot 1024\cdot 8}{0.2}=5,242,880\approx 5.24\text{ Mbps}
   $$
   b. The client browser and operating system will check if the local cache is available. If not, the client side will issue a request to the local non-authoritative DNS cache server. If the cache is not hit, then it will send request to the server responsible for the `cs` domain, 