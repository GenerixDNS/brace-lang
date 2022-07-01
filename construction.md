# Compiler 

---

The Brace language is based on a java compiler, but the runtime does not run on java.<br>
This document describes how the brace compiler works. <br>

---

First, the compiler loads the specified project into a `BraceBuffer`.<br>
After that, the `BraceBuffer` is sent to a `BraceAllocator`, which divides the scripts<br>
and sends them to the `BraceRawCluster`. In this, only the source code is listed in an ordered manner.<br>
On the one hand, there is a cluster for constant objects,<br>
classes objects and functions. After that,<br>
the `BraceTransport` informs the `BraceDataCluster` that the raw data is ready so that it analyzes the data.<br>