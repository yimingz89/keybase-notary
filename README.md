Keybase Notary
Authors: Robert Chen, John Kuszmaul, and Yiming Zheng
Mentored by: Alin Tomescu

First, you must install Catena to your local Maven repository:

	git clone https://github.com/alinus/catena-java
	cd catena-java/
	./install-catena.sh

To_Do

- Add test cases for witnessing scheme - specifically make sure that
  equivocation is impossible (not the case now).
- Add test case for writing seqnos and txns to file
- In the event of network failure, back off exponentially until ~10 minutes. Leave log messgaes for the user.

Conistency Notes:
- Our indentations are 4 spaces. Eclipse automatically uses tabs, but this can be easily changed if you google it.