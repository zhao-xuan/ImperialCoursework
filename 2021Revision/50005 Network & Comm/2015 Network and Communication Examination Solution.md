# 2015 Network and Communication Examination Solution

1. a. IMAP stores mails on server so that user can trace the incoming mails on different computers. POP3 cannot do this because it implicitly assumes that all retrieved emails are deleted on the server. (i.e. POP3 stores email on local machine)

   b. Packet switching takes less time to set up but has higher processing overhead as it needs to determine which route to use to send packets. Circuit switching takes more time to set up but does not switch connection once it is established. However, packet switching shares links and has higher utilization rate than circuit switching because when circuit goes idle, no other connection can share/use it.

   c. i) We can first use `nslookup -type=NS www.ststephens.edu` to get the authoritative DNS server, then use `nslookup www.ststephens.edu <authoritative dns server>` to get an authoritative answer.

   ​	ii) The canonical name is the primary/properly defined domain name of the server. There could be alias that refers to this canonical name.

   ​	iii) The first time lookup has not hit the local DNS cache (not present or expired) and might need to go down to the next level to find correct DNS. The second time it hits the cache.

   d. i) 10 Mbit/s

   ​	ii) TCP will have a higher throughput because it controls congestion and has mechanism to retransmit lost packet. Hence it will recover quickly from packet loss and continue transmissino. UDP is more suitable for transmitting smaller framents. It does not handle packet loss and might require application layer to handle the packet loss, which takes longer time to recover.

   ​	iii) Assuming MSS = 5000 bits. Using the maximum throughput rate we can calculate the window size
   $$
   \lambda=\frac{W}{\text{RTT}}\Rightarrow W=\lambda\cdot \text{RTT}=10^7\cdot (0.07\cdot 2)=1.4\times 10^6\text{ Byte}=1.4\text{ MByte}
   $$
   ​		The TCP congestion first runs slow start to windows size up to $1.4\text{ MByte}$. When packet loss occurs at this windows size, TCP congestion control will cut the window size half to $0.7\text{ MBytes}$. From now on, most of the retransmission will occur under fast recovery scheme. From $0.7$ to $1.4$ MByte, it takes about $\frac{700\text{ KByte}}{5\text{ KByte}}\cdot \text{RTT}=140\text{ RTT}=140\cdot 0.14\text{ ms}=19.6\text{ s}$ to reach, which is the average time it takes to re-transmit a packet.

2. a. The longest-prefix matching will match the IP address in the forwarding table with the longest common prefix with the given IP address. In other words, it will try to match the IP address in the forwarding table as long as possible.

   b. i) Entry 2 has common prefix of the first 18 digit while entry 5 has common prefix of the first 22 digit. Hence it will be matched to port 4.

   ​	ii) Match to port 1 in entry 3

   ​	iii) Match to port 2 because it does not match any other IP address prefix. 0.0.0.0/0 will be the default fallback of unrecognized IP address like this one.

   c. Entry 6 is invalid because it is an internal private IP address which will probably not be recognized anyway since no incoming packets from outside the subnet will have this IP address.

   d. Entry 1 and 7 can be merged together as they reserve the same number of bits in their prefix. We can merge them together with reservation of the first 25 bits. (i.e. 173,194.66.0/25). Entry 6 can be deleted as it's invalid and all packets will still fall through port 2.