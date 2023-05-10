package com.arsenosov.data.computers

enum class GraphicsOutput {
    HDMI, VGA, DVI, USB, DP
}

enum class CPUSocket {
    AMD, INTEL
}

enum class MotherboardFormFactor {
    ATX, EXTENDED_ATX, FLEX_ATX, MICRO_ATX, MINI_ITX, SSI_CEB, ULTRA_ATX, XL_ATX
}

enum class RAMTechnology {
    DDR, DDR2, DDR3, DDR3L, DDR4, DDR5, DRAM
}

enum class StorageType {
    HDD, SSD
}

enum class StorageOutput {
    PATA, SATA, ESATA, FIREWIRE, SCSI, SAS, USB, THUNDERBOLT
}

enum class KeyboardInterface {
    BLUETOOTH, USB, USB_C, PS2
}

enum class KeyboardType {
    MEMBRANE, SCISSOR_SWITCH, MECHANICAL
}


enum class MouseInterface {
    BLUETOOTH, USB, PS2
}

enum class GPUMemory {
    GDDR, DDR
}

enum class AudioOutputMode {
    MONO, STEREO, SURROUND
}

enum class AudioOutput {
    PCI, FIREWIRE, USB, PCIE
}

enum class ExpansionSlot {
    AGP, AMR, CNR, EISA, ISA, PCI, PCIE, VESA
}
