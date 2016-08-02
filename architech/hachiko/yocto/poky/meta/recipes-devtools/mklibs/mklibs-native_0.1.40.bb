DESCRIPTION = "mklibs produces cut-down shared libraries that contain only the routines required by a particular set of executables."
HOMEPAGE = "https://code.launchpad.net/mklibs"
SECTION = "devel"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=98d31037b13d896e33890738ef01af64"
DEPENDS = "python-native dpkg-native"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/m/mklibs/${BPN}_${PV}.tar.xz \
	file://ac_init_fix.patch\
	file://fix_STT_GNU_IFUNC.patch\
"

#SRC_URI[md5sum] = "e597b01548204874feef396403615d9f"
#SRC_URI[sha256sum] = "e7fe79db2673bb26c98c63fd8b40dcb44b9b94c4bc52a8c4c8112a5cbaf29bf4"

SRC_URI[md5sum] = "e1dafe5f962caa9dc5f2651c0723812a"
SRC_URI[sha256sum] = "1db24ae779d21ccfed49f22e49a2b7ee43ec0e9197bc206d81cd02f96e91e125"


inherit autotools gettext native pythonnative

do_configure_prepend() {
	sed "s+MKLIBS_VERSION+${PV}+" ${S}/configure.ac
}
